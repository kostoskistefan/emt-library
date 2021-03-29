import React from 'react';
import {Link} from 'react-router-dom';

const authorTerm = (props) => {
    return (
        <tr className={"row"}>
            <td className={"col border-0 align-self-center"}>{props.author.name}</td>
            <td className={"col border-0 align-self-center"}>{props.author.surname}</td>
            <td className={"col border-0 align-self-center"}>{props.author.country.name}</td>
            <td className={"col-3 border-0 align-self-center"}>
                <Link className={"btn btn-primary mr-3"}
                      to={"/authors/edit/" + props.author.id}
                      onClick={() => props.onEdit(props.author.id)}>Edit</Link>
                <button className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.author.id)}>Delete</button>
            </td>
        </tr>
    )
}

export default authorTerm;