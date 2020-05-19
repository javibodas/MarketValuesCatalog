import { API_URL } from '../settings';

export default function getIndexStocks(){
	console.log(API_URL)
	const URI = encodeURI(API_URL + '/index')
	return fetch(URI)
      	    .then(res => res.json());

}