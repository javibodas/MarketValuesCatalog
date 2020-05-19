import { API_URL } from '../settings';

export default function getUsers(token){
	
	const URI = API_URL + '/user';
	return fetch(URI, { headers : { 'Authorization' : token }})
      	    .then(res => res.json())
}