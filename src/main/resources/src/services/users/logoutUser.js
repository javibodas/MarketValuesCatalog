import { API_URL } from '../settings';

export default function loginUser(formData){
	
    const URI = API_URL + '/logout';
	return fetch(URI)
      	    //.then(res => res.json())
}