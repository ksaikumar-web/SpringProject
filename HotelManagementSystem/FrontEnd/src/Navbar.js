import React from 'react'
import {Link} from 'react-router-dom';

const Navbar = () => {
  return (
    <div className='navigation'>
        <table>
            <tr><td><Link to="/" className="reg">Login</Link></td><td><Link to="/Registration" className="reg" >Registration</Link></td></tr>
            <tr></tr>
        </table>

      
    </div>
  )
}

export default Navbar