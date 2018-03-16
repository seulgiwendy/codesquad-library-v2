import '../main.css';
import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import {Nav, Navbar, NavItem, Button, FormGroup, FormControl, Glyphicon, InputGroup} from 'react-bootstrap';

class MainNavbar extends Component {
    render() {
        return(
            <div className="navbar-default">
            
            <Navbar className="navbar-default" fixedTop={true}>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <strong id="navbar-title">Codesquad Library</strong>
                        </Navbar.Brand>
                    </Navbar.Header>
                    <Nav className="navbar-letter">
                            <NavItem id = "navbar-menu"> <Link to={'/search'} id="navbar-menu">도서검색 </Link></NavItem>
                            <NavItem id = "navbar-menu" activehref="#"> 도서관리 </NavItem>
                            <NavItem id = "navbar-menu" activehref="#"> 대출정보 </NavItem>
                            <li role="presentation">
                                <form className="form-inline navbar-search">
                                    <input className="form-control mr-sm-2 search-area" type="search" placeholder="제목으로 검색..." aria-label="search"/>
                                    <button className="btn btn-default my-2 my-sm-0 search-button" type="submit"><Glyphicon glyph="search"/></button>
                                </form>
                            </li>
                    </Nav>
                    
                    
                    <Nav className="navbar-personal" pullRight>
                            <Button bsStyle = "primary" activehref="#" id = "navbar-button"> Login </Button>
                    </Nav>
                </Navbar>
                
            </div>
        )
    }
}

export default MainNavbar;