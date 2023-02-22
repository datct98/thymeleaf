function deleteWallet(id) {
    fetch("http://localhost:8081/deleteWallet/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
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