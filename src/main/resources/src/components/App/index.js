import ReactDOM from 'react-dom'
import React from 'react'
import Header from '../Header'
import Search from '../SearchValues'
import Footer from '../Footer'



function App() {
  return (<React.Fragment>
          <Header />
          <Search />
          <Footer />
        </React.Fragment>);
}

export default App;

ReactDOM.render(<App />, document.getElementById('root'));

