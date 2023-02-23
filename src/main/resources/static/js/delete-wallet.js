function deleteWallet(id) {
    var email = document.getElementById("email");
    fetch("http://localhost:8081/sendOtp/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }, body:JSON.stringify({
            email: email
        })
    })
        .then(response => response.json())
        .then(data => {
            console.log(data.message);
            alert(data.message)
            location.reload();
        })
        .catch(error => {
            console.error(error.toString());
        });
}