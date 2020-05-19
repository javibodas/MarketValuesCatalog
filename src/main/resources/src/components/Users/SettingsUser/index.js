import React, { useContext } from 'react'
import UserContext from '../../../context/userContext';

export default function SettingsUser(props){

    const { user, setUser } = useContext(UserContext);


    const handleModifyDataUser = function(event){

    }

    return(
        <div className="container">
            <form onSubmit={handleModifyDataUser}>
                <div class="form-group row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" readonly class="form-control-plaintext" id="staticEmail" value={user.userData.email} />
                    </div>
                </div>
            </form>
        </div>
    );
}