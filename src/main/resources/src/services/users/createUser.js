import { API_URL } from '../settings';

export default function createUser(){
	
	const URI = API_URL + '/user';
	var data = {username: 'example'};

	return fetch(URI,{
			method: 'POST',
			body: JSON.stringify(data)})
      	.then(res => res.json())
}