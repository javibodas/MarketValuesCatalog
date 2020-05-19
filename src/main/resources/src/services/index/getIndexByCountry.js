import { API_URL } from '../settings';

export default function getIndexByCountry(country){
	
	const URI = API_URL + `/index/${country}`;
	return fetch(URI)
      	    .then(res => res.json())
}