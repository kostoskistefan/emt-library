import React from "react";
import {Link} from "react-router-dom";

export default class Header extends React.Component {
    render() {
        return (
            <nav className={"navbar navbar-expand-md navbar-dark navbar-fixed bg-dark mb-3"}>
                <div className={"container"}>
                    <a className="navbar-brand" href={"/"}>EMT Library</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"/>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav ml-auto">
                            <li className="nav-item mr-3">
                                <Link className="nav-link" to="/books">Books</Link>
                            </li>
                            <li className="nav-item mr-3">
                                <Link className="nav-link" to="/authors">Authors</Link>
                            </li>
                            <li className="nav-item mr-3">
                                <Link className="nav-link" to="/countries">Countries</Link>
                            </li>
                            <li className="nav-item mr-5">
                                <Link className="nav-link" to="/categories">Categories</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        )
    }
}