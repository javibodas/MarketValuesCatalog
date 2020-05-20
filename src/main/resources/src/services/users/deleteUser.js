import { API_URL } from '../settings';

export default function deleteUser(userObjid, token){
	
	const URI = API_URL + `/user/${userObjid}`;
	return fetch(URI,{ method: 'DELETE', headers:{ 'Authorization': token } })
      	.then(res => res.json())
}