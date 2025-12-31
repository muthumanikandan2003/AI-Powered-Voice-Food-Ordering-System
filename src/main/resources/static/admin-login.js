function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/api/admin/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username: username, password: password })
    })
    .then(res => res.json())
    .then(success => {
        if (success === true) {
            localStorage.setItem("adminLoggedIn", "true");
            window.location.href = "admin.html";
        } else {
            document.getElementById("error").innerText = "Invalid credentials";
        }
    })
    .catch(err => {
        console.error(err);
        document.getElementById("error").innerText = "Server error";
    });
}

    function goto_order() {
        window.location.href = "index.html";
    }

