import React, { useState, useEffect, useContext } from 'react';
import UserContext from '../../context/userContext';
import getUsers from '../../services/users/getUsers';

export default function Users(){

	const [ users , setUsers ] = useState([]);
	const { user } = useContext(UserContext);

    useEffect(function(){
        getUsers(user.token)
		.then((result) => { setUsers(result); })
		.catch((error) => { console.log('ERROR:' + error)})
	},[]);

    return(<div className="container">
            <table border="2" className="table table-dark table-hover">
					<tr>
						<th><b>Name</b></th>
						<th><b>User Name</b></th>
						<th><b>Email</b></th>
						<th><b>Role</b></th>
					</tr>
					{users.map((user) =>  
						<tr>
							<td>{user.name}</td>
							<td>{user.username}</td>
							<td>{user.email}</td>
							<td>{user.roles.length > 1 ? user.roles.reduce((prevEl, actEl) => { return prevEl.role + "," + actEl.role }) : user.roles[0].role}</td>
						</tr>
					)}
				</table>
        </div>)


}