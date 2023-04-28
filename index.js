import React, { Component } from 'react';
import {
	requireNativeComponent,
	UIManager,
	NativeModules,
	Platform,
	findNodeHandle,
} from 'react-native';
import PropTypes from 'prop-types';
import _ from 'lodash';

const BridPlayerViewManager =
	Platform.OS === 'ios'
		? NativeModules.BridPlayerViewManager
		: NativeModules.BridSdkModule;

let playerId = 0;
const BRID_PLAYER_REF = 'BridPlayerKey';

const RnBridPlayer = requireNativeComponent('BridtvplayerView', null);

export default class Bridtvplayer extends Component {
  static propTypes = {
	videoconfig : PropTypes.shape({
			playerid: PropTypes.string,
			videoid: PropTypes.string,
			autoplay: PropTypes.bool
		}),
		setFullscreen: PropTypes.func,
		seekTo: PropTypes.func,
		loadPlaylist: PropTypes.func,
		onPlay: PropTypes.func,
		onPause: PropTypes.func,

	};
  constructor(props) {
		super(props);

		this._playerId = playerId++;
		this.ref_key = `${BRID_PLAYER_REF}-${this._playerId}`;

		// this.quite();
	}

  render() {
		return (
			<RnBridPlayer
				ref={(player) => (this[this.ref_key] = player)}
				key={this.ref_key}
				{...this.props}
			/>
		);
	}
}