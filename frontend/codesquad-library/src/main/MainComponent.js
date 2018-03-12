import React, {Component} from 'react';
import {Navbar, NavItem, MenuItem, NavDropdown, Nav} from 'react-bootstrap';

class MainComponent extends Component {
    render() {
        return (
            <div className="main">
                <Navbar>
                    <Navbar.Header>
                        <Navbar.Brand>
                            Codesquad Library
                        </Navbar.Brand>
                    </Navbar.Header>
                    <Nav>
                        <NavItem href="#"> 도서검색 </NavItem>
                        <NavItem href="#"> 도서관리 </NavItem>
                        <NavItem href="#"> 대출정보 </NavItem>
                    </Nav>
                </Navbar>
            </div>
        )
    }
}

export default MainComponent;