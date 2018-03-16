import React, {Component} from 'react';
import './search.css';
import MainNavbar from '../main/main-navbar/MainNavbar';
import MainFooter from '../main/MainFooter';
import { FormGroup, InputGroup, FormControl, DropdownButton, MenuItem } from 'react-bootstrap';

const bookCount = 10000;

const categories = ['제목', '저자', 'ISBN', '출판사']

class SearchPage extends Component {
    render() {
        return(
            <div className="main-search">
                <MainNavbar/>
                <div className="main-search search-component">
                    <div className="main-search search-view">
                        <h1 className="text-center">검색하기</h1>
                        <p className="text-center">코드스쿼드의 수많은 책들을 검색해보세요. 현재 {bookCount}권의 책이 준비되어 있습니다.</p>
                    </div>
                    <div className="container-fluid">
                        <div className="search-box center-block">
                            <FormGroup className="search-box search-form center-block">
                                <InputGroup>
                                    <FormControl type="text"/>
                                    <DropdownButton componentClass={InputGroup.Button} id="input-dropdown-addon" title="검색기준">
                                        {categories.map((content, i) => {
                                            return(
                                                <MenuItem key={i}>{content}</MenuItem>  
                                            )
                                        })}
                                    </DropdownButton> 
                                </InputGroup>
                            </FormGroup>
                        </div>
                    </div>
                </div>
                <div className="container-fluid default-footer">
                    <MainFooter/>
                </div>
            </div>
        )
    }
}

const searchRequest = (keyword, criteria) => {

}

export default SearchPage;