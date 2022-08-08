import React,{useState} from 'react'
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Registration from './Components/Registration/Registration';
import Login from './Components/Login/Login';
import Customer from './Components/Customer/Customer';
import Menu from './Components/Menu/menu';
import CustomerRooms from './Components/CustomerRooms/CustomerRooms';
import CustomerDetails from './Components/CustomerDetails/CustomerDetails';
import Navbar from './Navbar';
import Homepage from './Components/HomePage/Homepage';
import Orderfood from './Components/Orderfood/Orderfood';
import Roombooking from './Components/Roombooking/Roombooking';
export const App = () => {
  const[name,setName]=useState("SaiKumar");
  return (
    <div>
     <BrowserRouter>
    <Routes>
        <Route path="/Registration" element={<Registration/>}></Route>
        <Route path="/" element={<Login/>}/>
        <Route path="/Customer" element={<Customer/>}/>
        <Route path="/Homepage" element={<Homepage/>}/>
        <Route path="/Orderfood" element={<Orderfood/>}/>
        <Route path="/Roombooking" element={<Roombooking/>}/>
        <Route path='/menu' element={<Menu/>}/>
        <Route path='/CustomerRooms' element={<CustomerRooms/>}/>
        <Route path='/CustomerDetails' element={<CustomerDetails/>}/>
        <Route path="/customersOrders" element={<customerOrders/>}/>
    </Routes>
    </BrowserRouter> 
    </div>
  )
}

export default App
