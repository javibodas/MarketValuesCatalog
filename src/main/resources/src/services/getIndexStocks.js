const API_URL = window.location.hostname === 'localhost' ? 'http://localhost:8080' : 'https://marketvaluescatalog.herokuapp.com';

export default function getIndexStocks(){
	
	const URI = encodeURI(API_URL + '/index')
	return fetch(URI)
      	    .then(res => res.json());

}