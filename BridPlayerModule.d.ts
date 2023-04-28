// declare module "react-native-brid-tv-player" {
  import React from "react";

  interface AudioTrack {
    autoSelect: boolean;
    defaultTrack: boolean;
    groupId: string;
    language: string;
    name: string;
  }
  interface CastingDevice {
    name?: string;
    identifier?: string;
  }
  interface Source {
    file: string;
    label: string;
    default?: boolean;
  }
  interface Track {
    file: string;
    label: string;
    default?: boolean;
  }
  interface AdSchedule {
    tag: string;
    offset: string;
  }
  type ClientTypes = "vast" | "ima" | "ima_dai";
  interface Advertising {
    adSchedule?: AdSchedule;
    adVmap?: string;
    tag?: string;
    openBrowserOnAdClick?: boolean;
    adClient?: ClientTypes;
  }
  interface PlaylistItem {
    file: string;
    sources?: Source[];
    image?: string;
    title?: string;
    description?: string;
    mediaId?: string;
    adSchedule?: AdSchedule;
    adVmap?: string;
    tracks?: Track[];
    recommendations?: string;
    startTime?: number;
    autostart?: boolean;
  }
  type RelatedOnClicks = "play" | "link";
  type RelatedOnCompletes = "show" | "hide" | "autoplay";
  interface Related {
    onClick?: RelatedOnClicks;
    onComplete?: RelatedOnCompletes;
    heading?: string;
    url?: string;
    autoplayMessage?: string;
    autoplayTimer?: number;
  }
  interface Font {
    name?: string;
    size?: number;
  }
  type EdgeStyles = "none" | "dropshadow" | "raised" | "depressed" | "uniform";
  interface Styling {
    colors?: {
      buttons?: string;
      backgroundColor?: string;
      fontColor?: string;
      timeslider?: { progress?: string; rail?: string; thumb?: string };
    };
    font?: Font;
    displayTitle?: boolean;
    displayDescription?: boolean;
    captionsStyle?: {
      font?: Font;
      fontColor?: string;
      backgroundColor?: string;
      highlightColor?: string;
      edgeStyle?: EdgeStyles;
    };
    menuStyle: {
      font?: Font;
      fontColor?: string;
      backgroundColor?: string;
    };
  }
  type Preloads = "auto" | "none";
  type InterfaceBehaviors = "normal" | "hidden" | "onscreen";
  type UIGroups =
    | "overlay"
    | "control_bar"
    | "center_controls"
    | "next_up"
    | "error"
    | "playlist"
    | "controls_container"
    | "settings_menu"
    | "quality_submenu"
    | "captions_submenu"
    | "playback_submenu"
    | "audiotracks_submenu"
    | "casting_menu";
  type AudioSessionCategory =
    | "Ambient"
    | "SoloAmbient"
    | "Playback"
    | "Record"
    | "PlayAndRecord"
    | "MultiRoute";
  type AudioSessionCategoryOptions =
    | "MixWithOthers"
    | "DuckOthers"
    | "AllowBluetooth"
    | "DefaultToSpeaker"
    | "InterruptSpokenAudioAndMix"
    | "AllowBluetoothA2DP"
    | "AllowAirPlay"
    | "OverrideMutedMicrophone";
  type AudioSessionMode =
    | "Default"
    | "VoiceChat"
    | "VideoChat"
    | "GameChat"
    | "VideoRecording"
    | "Measurement"
    | "MoviePlayback"
    | "SpokenAudio"
    | "VoicePrompt";
  type JWControlType =
    | "forward"
    | "rewind"
    | "pip"
    | "airplay"
    | "chromecast"
    | "next"
    | "previous"
    | "settings"
    | "languages"
    | "fullscreen";
  interface VideoConfig {
    playerid: string;
    videoid: string;
    autoplay: Boolean;
  }
  interface PropsType {
    videoconfig: VideoConfig;
  }
  export default class BridPlayer extends React.Component<PropsType> {
    pause(): void;
    play(): void;
    stop(): void;
    loadVideo(): void;
    loadPlaylist(playlistItems: PlaylistItem[]): void;
    setVolume(volume: number): void;
    setControls(show: boolean): void;
    seekTo(time: number): void;
    setFullscreen(fullScreen: boolean): void;
  }


// }
