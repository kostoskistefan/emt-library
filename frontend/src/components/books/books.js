import React from "react";
import {Link} from 'react-router-dom';
import BookTerm from './bookTerm';
import ReactPaginate from 'react-paginate';

export default class Books extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 5
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getBooksPage(offset, nextPageOffset);

        return (
            <div className={"container"}>
                <h1 className={"text-center mb-3"}>Books</h1>
                <table className={"table table-striped"}>
                    <thead>
                    <tr className={"row"}>
                        <th className={"col"}>Name</th>
                        <th className={"col"}>Category</th>
                        <th className={"col"}>Author</th>
                        <th className={"col"}>Available Copies</th>
                        <th className={"col-4"}>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {books}
                    </tbody>
                </table>
                <Link className={"btn float-right btn-success"} to={"/books/add"}>Add new book</Link>
                <ReactPaginate breakClassName={'page-item'}
                               breakLinkClassName={'page-link'}
                               pageClassName={'page-item'}
                               pageLinkClassName={'page-link'}
                               previousClassName={'page-item'}
                               previousLinkClassName={'page-link'}
                               nextClassName={'page-item'}
                               nextLinkClassName={'page-link'}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination"}
                               activeClassName={"active"}/>
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map(book => {
            return <BookTerm key={book.id} book={book}
                             onDelete={this.props.onDelete}
                             onEdit={this.props.onEdit}
                             onTaken={this.props.onTaken}/>
        }).filter((book, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }
}