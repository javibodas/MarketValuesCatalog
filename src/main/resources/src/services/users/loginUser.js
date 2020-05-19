import { API_URL } from '../settings';

export default function loginUser(creds){
	
    const URI = API_URL + '/login';
	return fetch(URI,{
            method: 'POST',
            body: JSON.stringify(creds)})
}