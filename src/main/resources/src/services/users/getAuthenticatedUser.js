import { API_URL } from '../settings';

export default function getAuthenticatedUser(token){
	
	const URI = API_URL + '/user/authenticated';
	return fetch(URI, {
                    method: 'GET',
                    headers:{
                        'Authorization': token
                    }
                })
      	    .then(res => res.json())
}