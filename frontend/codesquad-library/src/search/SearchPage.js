import React, {Component} from 'react';
import './search.css';
import MainNavbar from '../main/main-navbar/MainNavbar';
import MainFooter from '../main/MainFooter';

class SearchPage extends Component {
    render() {
        return(
            <div className="main-search">
                <MainNavbar/>

                <div className="container-fluid default-footer">
                    <MainFooter/>
                </div>
            </div>
        )
    }
}

export default SearchPage;