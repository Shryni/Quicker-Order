// MainForm.jsx
import React, { Component } from 'react';
//import UserDetails from './UserDetails';
import VendorStore from './VendorStore';
import RequestorStore from './RequestorStore';
import Quotation from './Quotation';
import PurchaseRequisition from './PurchaseRequisition';
import Requestor from './Requestor';
import PurchaseOrder from './PurchaseOrder';
import Item from './Item';
import Invoice from './Invoice';

class MainForm extends Component {
    state = {
        step: 2,

    }

    nextStep = () => {
        const { step } = this.state
        this.setState({
            step : step + 1
        })
    }

    prevStep = () => {
        const { step } = this.state
        this.setState({
            step : step - 1
        })
    }

    handleChange = input => event => {
        this.setState({ [input] : event.target.value })
    }

    render(){
    console.log("Render---?")
        //const {step} = this.state;
        const { Requestor_store_name,Requestor_storeAddress_line1,Requestor_storeAddress_line2,Requestor_storeAddress_line3,Requestor_store_city,Requestor_store_postal_code,Requestor_store_contact,Requestor_store_email,vendor_store_name, vendor_storeAddress_line1, vendor_storeAddress_line2,vendor_storeAddress_line3,vendor_store_city,vendor_store_postal_code,vendor_store_contact, vendor_store_email} = this.state;
        const values = { Requestor_store_name,Requestor_storeAddress_line1,Requestor_storeAddress_line2,Requestor_storeAddress_line3,Requestor_store_city,Requestor_store_postal_code,Requestor_store_contact,Requestor_store_email,vendor_store_name, vendor_storeAddress_line1, vendor_storeAddress_line2,vendor_storeAddress_line3,vendor_store_city,vendor_store_postal_code,vendor_store_contact, vendor_store_email };


        return <Item
                            nextStep={this.nextStep}
                            handleChange = {this.handleChange}
                            values={values}
                            />

     return <RequestorStore
                                nextStep={this.nextStep}
                                handleChange = {this.handleChange}
                                values={values}
                                />

    }
}

export default MainForm;