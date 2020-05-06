export default function getIndexStocks(){

    var reqOptions = { method: 'GET',headers: new Headers(),mode: 'cors',cache: 'default' }

	return fetch('http://localhost:8080/index')
      	    .then(res => res.json());

}