import React, { Component } from 'react';
import { connect } from 'react-redux';
import CSSModules from 'react-css-modules';
import { Timeline } from 'antd';

import { getCommentsDesc } from '../../data/comments/reducer';
import Comment from './components/Comment';
import styles from './styles.scss';
import {addAll} from "../../data/comments/actions";

class CommentsContainer extends Component {
	componentDidMount() {
		console.log("Loading all comments from service");
		this.props.dispatch(addAll())
	}

	render() {
		return (
			<div styleName="Comments">
				<h2>Comments</h2>
				{this.props.comments.length ? (
					<Timeline>
						{this.props.comments.map((comment, index) => (
							<Comment
								key={index}
								{...comment}
							/>
						))}
					</Timeline>
				) : 'No comments'}
			</div>
		)
	}
}

export default connect(state => ({
	comments: getCommentsDesc(state.Feedback.data.comments),
}))(CSSModules(CommentsContainer, styles));
