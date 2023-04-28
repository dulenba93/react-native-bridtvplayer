declare module "react-native-bridtvplayer" {
    import React from "react";
      interface VideoConfig {
      playerid: string;
      videoid: string;
      autoplay: Boolean;
    }
    interface PropsType {
      videoconfig: VideoConfig;
    }
    export default class Bridtvplayer extends React.Component<PropsType> {
      pause(): void;
      play(): void;
      stop(): void;
      loadVideo(): void;
      loadPlaylist(): void;
      setVolume(volume: number): void;
      setControls(show: boolean): void;
      seekTo(time: number): void;
      setFullscreen(fullScreen: boolean): void;
    }
  

  }
  