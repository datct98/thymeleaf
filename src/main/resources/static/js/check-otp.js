function verifyOTP(){
    var otp = document.getElementById("otp").value;
    alert(otp);
    fetch("http://localhost:8081/saveUser", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }, body:JSON.stringify({
            otp: otp
        })
    }).then(r =>r.json())
        .then(data => {
        console.log(data.message);
        alert(data.message)
        location.reload();
    })
        .catch(error => {
            console.error(error.toString());
        });
}

/*
function registerTemp(){
    fetch("http://localhost:8081/saveUserTemp", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }, body:JSON.stringify({
            username: document.getElementById("username"),
            password: document.getElementById("password"),
            email: document.getElementById("email")
        })
    }).then(r =>r.json())
        .then(data => {
            console.log(data.message);
            alert(data.message)
            location.reload();
        })
        .catch(error => {
            console.error(error.toString());
        });
}*/
