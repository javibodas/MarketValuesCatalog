const API_URL = window.location.hostname === 'localhost' ? 'http://localhost:8080' : 'https://marketvaluescatalog.herokuapp.com';

export default function getSearchValues(value, country, index){

    //var reqOptions = { method: 'GET',headers: new Headers(),mode: 'cors',cache: 'default' }
	const URI = encodeURI(API_URL + `/values/search?value=${value}&country=${country}&stock=${index}`)
	return fetch(URI)
      	    .then(res => res.json())

}