'using strict'

document.addEventListener("DOMContentLoaded", ()=>
{
    let name = document.getElementById("empName");
    let id = document.getElementById("empId");
    let email = document.getElementById("empEmail");
    let password = document.getElementById("empPass");

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4){
			var data = JSON.parse(xhr.response);
            name.value = data.first_name+" "+data.last_name;
            id.value = data.id;
            email.value = data.email;
            password.value = data.password;
		}
	};
	xhr.open('GET', './info', true);
    xhr.send();
});