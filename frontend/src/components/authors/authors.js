import React from "react";
import {Link} from 'react-router-dom';
import AuthorTerm from './authorTerm';

export default class Authors extends React.Component {
    // eslint-disable-next-line no-useless-constructor
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={"container mb-3"}>
                <h1 className={"text-center mb-3"}>Authors</h1>
                <table className={"table table-striped"}>
                    <thead>
                    <tr className={"row"}>
                        <th className={"col"}>Name</th>
                        <th className={"col"}>Surname</th>
                        <th className={"col"}>Country</th>
                        <th className={"col-3"}>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.props.authors.map(author => {
                        return <AuthorTerm key={author.id}
                                           author={author}
                                           onDelete={this.props.onDelete}
                                           onEdit={this.props.onEdit}/>
                    })}
                    </tbody>
                </table>
                <Link className={"btn float-right btn-success"} to={"/authors/add"}>Add new author</Link>
            </div>
        )
    }
}