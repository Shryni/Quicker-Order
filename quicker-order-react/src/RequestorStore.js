import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import { Form } from 'semantic-ui-react';
class RequestorStore extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/quickerorder/getAllRequestorStore">Requestor Store Details</Link></Button>
            <Form >
                            <h1 className="ui centered">Requestor Store Details</h1>
                            <Form.Field>
                                <label>Requestor Store Name: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Requestor Store Address Line1: </label>
                                <input
                                //placeholder='Requestor Store Address Line1:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line1')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Requestor Store Address Line2: </label>
                                <input
                                //placeholder='Requestor Store Address Line2:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line2')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Requestor Store Address Line3: </label>
                                <input
                                //placeholder='Requestor Store Address Line3:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line3')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>City: </label>
                                <input
                                //placeholder='City:'
                                //onChange={this.props.handleChange('Requestor_store_city')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Postal Code: </label>
                                <input
                                //placeholder='Postal Code:'
                                //onChange={this.props.handleChange('Requestor_store_postal_code')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>

                             <Form.Field>
                                <label>Requestor Store Contact: </label>
                                <input
                                //placeholder='Requestor Store Contact:'
                                //onChange={this.props.handleChange('Requestor_store_contact')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>

                            <Form.Field>
                                <label>Email Address: </label>
                                <input
                                type='email'
                                //placeholder='Email Address'
                                //onChange={this.props.handleChange('Requestor_store_email')}
                                //defaultValue={values.email}
                                />
                            </Form.Field>
                            <Button onClick={this.saveAndContinue}>Save And Continue </Button>
                        </Form>
        </Container>
      </div>
    );
  }
}

export default RequestorStore;