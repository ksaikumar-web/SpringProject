import React, { Component} from 'react'
import axios from 'axios';
import { withRouter } from '../../withRouter';
import Menu from '../Menu/menu';
import { useNavigate } from 'react-router-dom';
import moment from 'moment'
import {Link} from 'react-router-dom';
import { useState } from 'react';
export  class Roombooking extends Component {
    constructor(props) {
        super(props);
        let cid = localStorage.getItem("cid");
        const maxNumber=200;
        const randomNumber = Math.floor((Math.random() * maxNumber) + 1);
        this.state = {
         customerId:cid,
         bookingId:randomNumber,
         roomId:'',
         menuId:'',
         walletSource:'',
         days:'',
         bookingDate:'',
         wallets:[],
         menu:[],
         room:[]
        };
    }
    changeCustomerId(event) {  
     this.setState({  
         customerId : event.target.value
     });
   }
   changeBookingId(event){
    this.setState({
      bookingId : event.target.value
    })
   } 
   changeBookingDate(event) {  
    this.setState({  
        bookingDate : event.target.value
    });
  }  

     changeRoomId(event) {  
       this.setState({  
           roomId : event.target.value
       });  
     }

     changeMenuId(event) {  
       this.setState({  
           menuId : event.target.value
       });  
     }

     changeWalletSource(event){  
       this.setState({  
           walletSource : event.target.value
       });  
     }

     changeDays(event){  
       this.setState({  
           days : event.target.value
       });  
     }

     placeOrd = () => {
      console.log(this.state.bookingId);
      console.log(this.state.bookingDate);
       axios.post('http://localhost:8087/addNewBooking',
     {bookingId:this.state.bookingId, 
      emailId: this.state.customerId,
      roomId: this.state.roomId, 
       menuId: this.state.menuId,
       walletSource: this.state.walletSource,
       bookingDate:this.state.bookingDate, 
       days: this.state.days})
     .then(res => {
       console.log(res);
       console.log(res.data);
       this.state.result = res.data
       alert(res.data)
       this.props.navigate("/HomePage")
     })
     }

    componentDidMount(){
       axios.get('http://localhost:8087/getallwalletsource/'+this.state.customerId)
       .then(response=>{
         this.setState({
           wallets: response.data
         })
       })
       axios.get("http://localhost:8087/showMenu")
      .then(response => {
        this.setState({
          menu : response.data 
        })
        console.log(response.data)
      })
      axios.get("http://localhost:8087/showRooms")
      .then(response => {
        this.setState({
          room : response.data 
        })
        console.log(response.data)
      })
     }
     

   render() {
    
    const {wallets} = this.state;
    const{menu}=this.state;
    const{room}=this.state;
    let walletList = wallets.length > 0
        && wallets.map((item) => {
          return (
              <option value={item}>{item}</option>
          )
      }, this);
     return<div><div className='cont_order left'><div className="login__signupHS">
     <div className='menu-wrap'><p className='h1'>ROOMS</p>
     <table border="3" align='center'>
       <thead>
   <tr>
     <th>Room Id</th>
     <th>Room Type</th>
     <th>Price</th>
     <th>Status</th>
   </tr></thead>
   
   {
     room.map( m => 
       <tr>
         <td>{m.roomId}</td>
         <td>{m.room_type}</td>
         <td>{m.price}</td>
         <td>{m.room_status}</td>
       </tr>
   )
   }
 </table>
     <p className='h1'>MENU</p>
     <table border="3" align='center'>
       <thead>
   <tr>
     <th>Menu Id</th>
     <th>Name</th>
     <th>Price</th>
     <th>Speciality</th>
   </tr></thead>
   
   {
     menu.map( m => 
       <tr>
         <td>{m.menuId}</td>
         <td>{m.menuName}</td>
         <td>{m.menuPrice}</td>
         <td>{m.menuSpeciality}</td>
       </tr>
   )
   }
 </table><div>

 </div>
 </div></div></div>
 <div className='cont_order right'>
 <div className="food-wrap">
        <div class="login-html">
       <table align="center">
       
        <thead><th colSpan="2">Place Order</th></thead>
       <br/>
       <tr>
         <td><input hidden type="text" id="bookingId" value={this.state.bookingId} onChange={this.changeBookingId.bind(this)}></input></td>
       </tr>
       <tr>
         <td><input hidden type="text" id="customerId" value={this.state.customerId} onChange={this.changeCustomerId.bind(this)}></input></td>
       </tr><br/>
       <tr>
         <th>Menu Id</th>
        <td><input type="text" id = "menuId" value={this.state.menuId} onChange={this.changeMenuId.bind(this)}></input></td>
       </tr><br/>
       <tr>
       <th>Room Id</th>
         <td><input type="text" id = "roomId" value={this.state.roomId} onChange={this.changeRoomId.bind(this)}></input></td>
       </tr><br/>
       <tr>
       <th>Date</th>
          <td><input type="date" id = "BookingDate" value={this.state.bookingDate} onChange={this.changeBookingDate.bind(this)}></input></td>
        </tr><br/>
       <tr>
         <th>Select Wallet</th>
         <td><select onChange = {this.changeWalletSource.bind(this)}>
             {walletList}
           </select></td>
         {/* <td><input type="text" id="walSource" value={this.state.walSource} onChange={this.changeWalSource.bind(this)}></input></td> */}
       </tr><br/>
       <tr>
         <th>Days</th>
         <td><input type="text" id="days" value={this.state.days} onChange={this.changeDays.bind(this)}></input></td>
       </tr><br/>
       <tr>
         <th></th><td><input type="button" value="PlaceOrder" onClick={this.placeOrd} id="btn"></input></td>
       </tr>
       </table>
       </div></div></div>
       <Menu/>
        
   </div>;
     
  }
}
export default withRouter(Roombooking);