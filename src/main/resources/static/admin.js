const API = "http://localhost:8080/api/admin";

const foodInput = document.getElementById("food");
const priceInput = document.getElementById("price");
const menuList = document.getElementById("menuList");

    function logout() {
        localStorage.removeItem("adminLoggedIn");
        window.location.href = "admin-login.html";
    }

function addFood() {
    const name = foodInput.value;
    const price = priceInput.value;

    if (!name || !price) {
        alert("Enter food name and price");
        return;
    }

    fetch(API + "/menu", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, price })
    }).then(() => {
        foodInput.value = "";
        priceInput.value = "";
        loadMenu();
    });
}

function loadMenu() {
    fetch(API + "/menu")
        .then(res => res.json())
        .then(data => {
            menuList.innerHTML = "";
            data.forEach(item => {
                const li = document.createElement("li");
                li.innerHTML = `
                    ${item.name} ₹${item.price}
                    <button onclick="editFood(${item.id}, '${item.name}', ${item.price})">Edit</button>
                    <button onclick="deleteFood(${item.id})">Delete</button>
                `;
                menuList.appendChild(li);
            });
        });
}

function editFood(id, name, price) {
    const newPrice = prompt(`Enter new price for ${name}`, price);
    if (!newPrice) return;

    fetch(API + "/menu/" + id, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name: name, price: newPrice })
    }).then(loadMenu);
}

function deleteFood(id) {
    if (!confirm("Delete this item?")) return;

    fetch(API + "/menu/" + id, {
        method: "DELETE"
    }).then(loadMenu);
}

// Load menu when page opens
loadMenu();
