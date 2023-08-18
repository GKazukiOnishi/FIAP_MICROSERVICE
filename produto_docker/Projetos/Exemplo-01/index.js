const getUsers = async () => {
    const response = await fetch("http://localhost:8080/listUsers");
    const user = await response.json();
    console.log(user);
    return user;
};

const blocoUser = document.getElementById("bloco_user");

let user;
getUsers().then(response => {
    user = response;
    blocoUser.innerHTML = `${user.nome} - ${user.data}`;
});