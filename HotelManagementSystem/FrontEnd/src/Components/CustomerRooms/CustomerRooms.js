import React, { Component } from 'react'
import axios from 'axios';
import Menu from '../Menu/menu';
export default class CustomerRooms extends Component {
    constructor(props) {
        super(props);
        this.state = {
         orders : []
        };
    }
    
    componentDidMount(){
     let cid = localStorage.getItem("cid")
     console.log(cid)
     axios.get("http://localhost:8087/showBooking/"+cid)
     .then(response => {
       this.setState({
         orders : response.data
       })
       console.log(response.data)
     })
    }
    
    render() {
     const {orders} = this.state
     return <div className='cont'>
      <Menu/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
      <div className='login__signupHST'>
       <table border="3" align="center">
         <thead>
         <tr>
           <th>Booking Id</th>
           <th>Room Id</th>
           <th>Menu Id</th>
           <th>Booking Days</th>
           <th>Wallet Source</th>
           <th>Booking Date</th>
           <th>Bill Amount</th>
           <th>Booking Status</th>
         </tr></thead>
         
         {
           orders.map( order =>
             <tr>
               <td>{order.bookingId}</td>
               <td>{order.roomId}</td>
               <td>{order.menuId}</td>
               <td>{order.days}</td>
               <td>{order.walletSource}</td>
               <td>{order.bookingDate}</td>
               <td>{order.billAmount}</td>
               <td>{order.bookingStatus}</td>
               <td style={{'color': order.ordStatus === 'ACCEPTED' ? 'green' : order.ordStatus === 'DENIED' ? 'red' : 'violet'}}>{order.ordStatus}</td>
               <td>{order.ordComments}</td>
             </tr>
             )
         }
       </table></div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
     </div>;
    }
}
