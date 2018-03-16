import React, {Component} from 'react';
import MainComponent from './main/MainComponent';
import SearchPage from './search/SearchPage';
import {Route} from 'react-router-dom';

class Router extends Component {
    render() {
        return(
            <div>
                <Route exact path="/" component={MainComponent}/>
                <Route exact path="/search" component={SearchPage}/>
            </div>
        )
    }
}

export default Router;
