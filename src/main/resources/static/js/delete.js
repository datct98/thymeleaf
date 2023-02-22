function deleteUser(id) {
    fetch("http://localhost:8081/delete/"+id,{
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            console.log(data.message);
            alert(data.message)
        })
        .catch(error => {
            console.error(error.toString());
        });
}