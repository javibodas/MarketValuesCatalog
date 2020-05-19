import { API_URL } from '../settings';

export default function getCountries(){
	
	const URI = API_URL + '/country';
	return fetch(URI)
      	    .then(res => res.json())
}