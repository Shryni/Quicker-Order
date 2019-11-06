import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import { Form } from 'semantic-ui-react';
class Invoice extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/quickerorder/getAllInvoices">Invoice</Link></Button>
            <Form >
                            <h1 className="ui centered">Enter Invoice Details</h1>
                             <Form.Field>
                                <label>Invoice ID: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                                   </Form.Field>
                                   <Form.Field>
                               <label>Purchase Order ID: </label>
                                  <input
                                  //placeholder='Requestor Store Name'
                                  //onChange={this.props.handleChange('Requestor_store_name')}
                                  //defaultValue={values.firstName}
                                  />
                                     </Form.Field>

                               <Form.Field>
                                   <label>Invoice Name: </label>
                                   <input
                                   //placeholder='Requestor Store Name'
                                   //onChange={this.props.handleChange('Requestor_store_name')}
                                   //defaultValue={values.firstName}
                                   />
                            </Form.Field>

                            <Form.Field>
                                <label>Date: </label>
                                <input />
                            </Form.Field>

                        </Form>
        </Container>
      </div>
    );
  }
}

export default Invoice;