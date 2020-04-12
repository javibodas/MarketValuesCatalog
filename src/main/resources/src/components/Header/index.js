import React from 'react'

function Header(props){
    return(
        <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	        <a className="navbar-brand" href="#">MarketValuesApp</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    	        <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse user-login">
    	        <a className="btn btn-outline-light" href="#">Sign In</a>
    	        <a className="btn btn-outline-light" href="#">Sign Up</a>
            </div>
        </nav>
    )
}

export default Header