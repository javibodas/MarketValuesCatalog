import React, { useState } from 'react';

const Context = React.createContext({'authenticated' : false});

export function UserContextProvider({children}){

    const [ user, setUser ] = useState({'authenticated': false})

    return (
        <Context.Provider value={{user, setUser}}>
            {children}
        </Context.Provider>
    );
}

export default Context