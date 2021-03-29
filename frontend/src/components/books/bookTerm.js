import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return (
        <tr className={"row"}>
            <td className={"col border-0 align-self-center"}>{props.book.name}</td>
            <td className={"col border-0 align-self-center"}>{props.book.category.charAt(0).toUpperCase() + props.book.category.slice(1).toLowerCase()}</td>
            <td className={"col border-0 align-self-center"}>{props.book.author.name + " " + props.book.author.surname}</td>
            <td className={"col border-0 align-self-center"}>{props.book.availableCopies}</td>
            <td className={"col-4 border-0 align-self-center"}>
                <button className={"btn btn-success mr-3"}
                   onClick={() => props.onTaken(props.book.id)} disabled={props.book.availableCopies === 0}>Mark as Taken</button>
                <Link className={"btn btn-primary mr-3"}
                      to={"/books/edit/" + props.book.id}
                      onClick={() => props.onEdit(props.book.id)}>Edit</Link>
                <button className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.book.id)}>Delete</button>
            </td>
        </tr>
    )
}

export default bookTerm;