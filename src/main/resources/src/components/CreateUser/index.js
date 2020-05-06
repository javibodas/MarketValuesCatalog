import React, { useState , useEffect } from 'react';

export default function CreateUser(props){

    const [ formValues , setFormValues ] = useState({ firstName: '', 
                                                        lastName: '',
                                                        email: '',
                                                        username: '',
                                                        password: '' });
    
    useEffect(function(){ console.log('email modificado')},[formValues.email]);

    return (<div className="container">
                <form>
                    <div className="row">
                        <div className="col">
                            <input type="text" className="form-control" placeholder="First name" />
                        </div>
                        <div className="col">
                            <input type="text" className="form-control" placeholder="Last name" />
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <input type="text" className="form-control" placeholder="Email" value={formValues.email}/>
                        </div>
                        <div className="col">
                            <input type="text" className="form-control" placeholder="Username" />
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <input type="text" className="form-control" placeholder="Password" />
                        </div>
                        <div className="col">
                            <input type="text" className="form-control" placeholder="Repeat Password" />
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <input type="button" className="form-control" text="Create" />
                        </div>
                        <div className="col">
                            <input type="button" className="form-control" text="Cancel" />
                        </div>
                    </div>
                </form>
            </div>);
}