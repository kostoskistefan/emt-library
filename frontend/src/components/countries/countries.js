import React from "react";
import {Link} from 'react-router-dom';

export default class Countries extends React.Component {
    // eslint-disable-next-line no-useless-constructor
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={"container mb-3"}>
                <h1 className={"text-center mb-3"}>Countries</h1>
                <table className={"table table-striped"}>
                    <thead>
                    <tr className={"row"}>
                        <th className={"col"}>Name</th>
                        <th className={"col"}>Continent</th>
                        <th className={"col-4"}>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.props.countries.map(country => {
                        return (
                            <tr className={"row"} key={country.id}>
                                <td className={"col border-0 align-self-center"}>{country.name}</td>
                                <td className={"col border-0 align-self-center"}>{country.continent}</td>
                                <td className={"col-4 border-0 align-self-center"}>
                                    <Link className={"btn btn-primary mr-3"}
                                          to={"/countries/edit/" + country.id}
                                          onClick={() => this.props.onEdit(country.id)}>Edit</Link>
                                    <button className={"btn btn-danger"}
                                            onClick={() => this.props.onDelete(country.id)}>Delete
                                    </button>
                                </td>
                            </tr>
                        )
                    })}
                    </tbody>
                </table>
                <Link className={"btn float-right btn-success"} to={"/countries/add"}>Add new country</Link>
            </div>
        )
    }
}