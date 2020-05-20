import { API_URL } from '../settings';

export default function createUser(user){
	
	const URI = API_URL + '/user';
	return fetch(URI,{
			method: 'POST',
			headers: {'Content-Type':'application/json'},
			body: JSON.stringify(user)})
      	.then(res => res.json())
}