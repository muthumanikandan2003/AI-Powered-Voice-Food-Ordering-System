
    let waitingForAddress = false;

    function createRecognition() {
        const r = new webkitSpeechRecognition();
        r.lang = "en-IN";
        r.interimResults = false;
        r.continuous = false;
        return r;
    }

    // ---------------- ORDER ----------------
    function startOrderVoice() {
        const rec = createRecognition();
        rec.start();

        rec.onresult = e => {
            const text = e.results[0][0].transcript;
            document.getElementById("text").innerText = text;
            send(text, false);
        };
    }

    // ---------------- ADDRESS ----------------
    function startAddressVoice() {
        const rec = createRecognition();
        rec.start();

        rec.onresult = e => {
            const text = e.results[0][0].transcript;
            document.getElementById("text").innerText = text;
            send(text, true);
        };
    }

    function send(text, isAddress) {

        const endpoint = isAddress
            ? "http://localhost:8080/api/voice/address"
            : "http://localhost:8080/api/voice/order";

        fetch(endpoint, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ command: text })
        })
        .then(res => res.text())
        .then(reply => {

            if (reply.startsWith("ADDRESS_REQUIRED|")) {
                waitingForAddress = true;
                document.getElementById("addressBtn").disabled = false;
                reply = reply.split("|")[1];
            }

            if (reply.startsWith("ORDER_CONFIRMED|")) {
                waitingForAddress = false;
                document.getElementById("addressBtn").disabled = true;
                reply = reply.split("|")[1];
            }

            document.getElementById("result").innerText = reply;
            speak(reply);
        });
    }

    function speak(text) {
        const msg = new SpeechSynthesisUtterance(text);
        msg.lang = "en-IN";
        speechSynthesis.speak(msg);
    }
    function goToAdmin() {
        window.location.href = "admin-login.html";
    }
