const data = { username: 'example', password: '12345' };

fetch('https://api.example.com/login', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
})
    .then(response => response.json())
    .then(data => {
        // Xử lý dữ liệu trả về
    })
    .catch(error => {
        console.error('Lỗi:', error);
    });
