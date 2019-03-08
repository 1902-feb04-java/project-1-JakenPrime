'using strict'

document.addEventListener("DOMContentLoaded", function LoadEmpTable()
{
	let table = document.getElementById("reimburTable");
	while(table.hasChildNodes())
	{
	   table.removeChild(table.firstChild);
	}
	let isManager = false;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4){
			var tableData = JSON.parse(xhr.response);
			console.log(tableData);
			let head = 
				`<tr> 
					<th>Request ID</th>
                    <th>Reimbursement Status</th>
                    <th>Amount</th>
                    <th>Comments</th>
                </tr>`;
            table.insertAdjacentHTML('afterbegin', head);
			for (let item of tableData)
			{
				let html = 
					`<tr>
						<td>${item.id}</td>
						<td>${item.status}</td>
						<td>${item.amount}</td>
						<td>${item.comment}</td>
					</tr>`;

					table.insertAdjacentHTML('beforeend',html);
					isManager = item.manager;
			}
			if(isManager)
			{
				document.getElementById('viewEmp').style.visibility = 'visible';
				document.getElementById('viewPend').style.visibility = 'visible';
				document.getElementById('viewDone').style.visibility = 'visible';
			}
		}
	};
	xhr.open('GET', './EmployeeServlet', true);
	xhr.send();
	
	function UpdatePending(_id,_change)
	{
		$.post("update",{id: _id, change: _change},function(data,status){window.alert("UPDATED!"); LoadPendTable();});
	}

	document.getElementById('viewPend').addEventListener("click", function LoadPendTable()
	{
		while(table.hasChildNodes())
		{
		   table.removeChild(table.firstChild);
		}		
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = () => {
			if(xhr.readyState == 4){
				var tableData = JSON.parse(xhr.response);
				console.log(tableData);
				let head = 
					`<tr> 
						<th>Request ID</th>
	                    <th>Employee</th>
	                    <th>Amount</th>
	                    <th>Comments</th>
	                    <th>Status</th>
	                    <th colspan='2' align = 'center'>Action</th>
	                </tr>`;
	            table.insertAdjacentHTML('afterbegin', head);
				for (let item of tableData)
				{
					let html = 
						`<tr>
						<form>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.amount}</td>
							<td>${item.comment}</td>
							<td>${item.status}</td>
							<td align = 'center'><input type = 'button' id = 'A${item.id}' name='B${item.id}' 
								value = "Approve" onclick = "UpdatePending($item.id, 1)"></td>
							<td align = 'center'><input type = 'button' id = 'D${item.id}' name='B${item.id}' 
								value = "Deny" onclick ="UpdatePending($item.id, 3)"></td>
						</tr>`;

						table.insertAdjacentHTML('beforeend',html);
				}
				
			}
		};
		xhr.open('GET', './RequestServlet', true);
		xhr.send();
	});
	
	document.getElementById('viewDone').addEventListener("click", function LoadDoneTable()
	{
		while(table.hasChildNodes())
		{
		   table.removeChild(table.firstChild);
		}		
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = () => {
			if(xhr.readyState == 4){
				var tableData = JSON.parse(xhr.response);
				console.log(tableData);
				let head = 
					`<tr> 
						<th>Request ID</th>
	                    <th>Employee</th>
	                    <th>Amount</th>
	                    <th>Comments</th>
	                    <th>Status</th>
	                </tr>`;
	            table.insertAdjacentHTML('afterbegin', head);
				for (let item of tableData)
				{
					let html = 
						`<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.amount}</td>
							<td>${item.comment}</td>
							<td>${item.status}</td>
						</tr>`;

						table.insertAdjacentHTML('beforeend',html);
				}
				
			}
		};
		xhr.open('POST', './RequestServlet', true);
		xhr.send();
	});
	
	document.getElementById('viewEmp').addEventListener("click", function LoadAllEmp()
	{
		while(table.hasChildNodes())
		{
		   table.removeChild(table.firstChild);
		}		
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = () => {
			if(xhr.readyState == 4){
				var tableData = JSON.parse(xhr.response);
				console.log(tableData);
				let head = 
					`<tr> 
						<th>Employee ID</th>
	                    <th>First Name</th>
	                    <th>Last Name</th>
	                    <th>Email</th>
	                </tr>`;
	            table.insertAdjacentHTML('afterbegin', head);
				for (let item of tableData)
				{
					let html = 
						`<tr>
							<td>${item.id}</td>
							<td>${item.first_name}</td>
							<td>${item.last_name}</td>
							<td>${item.email}</td>
						</tr>`;

						table.insertAdjacentHTML('beforeend',html);
				}
				
			}
		};
		xhr.open('POST', './EmployeeServlet', true);
		xhr.send();
	});
	
	document.getElementById('viewMine').addEventListener("click", () => {
		console.log('click');
		LoadEmpTable();
	});

});