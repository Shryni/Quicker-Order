import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import { Form } from 'semantic-ui-react';
class PurchaseRequisition extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/quickerorder/getAllPurchaseRequisitions">Purchase Requisition</Link></Button>
            <Form >
                            <h1 className="ui centered">Purchase Requisition Details</h1>
                             <Form.Field>
                                <label>Purchase Requisition ID: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Title: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Created By: </label>
                                <input
                                //placeholder='Requestor Store Address Line1:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line1')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Created Date: </label>
                                <input
                                //placeholder='Requestor Store Address Line2:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line2')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Expected Date of Delivery: </label>
                                <input
                                //placeholder='Requestor Store Address Line3:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line3')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Status: </label>
                                <input
                                //placeholder='City:'
                                //onChange={this.props.handleChange('Requestor_store_city')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Additional Comments: </label>
                                <input
                                //placeholder='City:'
                                //onChange={this.props.handleChange('Requestor_store_city')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Save Template: </label>
                                <input
                                //placeholder='City:'
                                //onChange={this.props.handleChange('Requestor_store_city')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>

                            <Button onClick={this.saveAndContinue}>Save And Continue </Button>
                        </Form>
        </Container>
      </div>
    );
  }
}

export default PurchaseRequisition;