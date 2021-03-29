import React from "react";

export default class Categories extends React.Component {
    // eslint-disable-next-line no-useless-constructor
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={"container mb-3"}>
                <h1 className={"text-center mb-3"}>Categories</h1>
                <table className={"table table-striped"}>
                    <thead>
                    <tr className={"row"}>
                        <th className={"col"}>Category</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.props.categories.map(category => {
                        return (
                            <tr className={"row"} key={category}>
                            <td className={"col border-0 align-self-center"}>{category.charAt(0).toUpperCase() + category.slice(1).toLowerCase()}</td>
                            </tr>
                        )
                    })}
                    </tbody>
                </table>
            </div>
        )
    }
}